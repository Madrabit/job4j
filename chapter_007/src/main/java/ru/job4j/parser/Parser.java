package ru.job4j.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @author madrabit
 * Parser for site SQL.RU
 * Collect all vacancies from the beginning of this year.
 * Only for Java developers.
 * No double.
 */
public class Parser {
    private static final String DESCRIPTION = "#content-wrapper-forum > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(2)";
    private static final String DEFAULT_URL = "https://www.sql.ru/forum/job-offers";
    @SuppressWarnings({"FieldCanBeLocal", "RedundantSuppression"})
    private static final String PAGINATION = "#content-wrapper-forum > table:nth-child(7) > tbody > tr > td:nth-child(1) > a:nth-child(11)";
    private static final String USER_AGENT = "userAgent";
    private static final String REFERRER = "http://www.google.com";
    private static final String TITLE = "td:nth-child(2)";
    private static final String LINK = "td:nth-child(2) > a";
    private static final String PAGE = "#content-wrapper-forum > table.forumTable > tbody > tr:nth-child(n+5)";
    private static final String DATE = "td:nth-child(6)";

    /**
     * Unique vacancies.
     */
    private final Set<Vacancy> vacancySet = new LinkedHashSet<>();

    public Set<Vacancy> getVacancySet() {
        return vacancySet;
    }

    /**
     * Get vacancy description.
     *
     * @param url Vacancy URL.
     * @return Returning text description of vacancy.
     */
    private static String getDescription(String url) {
        Elements desc = getDocument(url).select(DESCRIPTION);
        String description = "";
        if (desc.size() != 0) {
            description = desc.get(0).text();
        }
        return description;
    }

    /**
     * Get amount of pages with vacancies.
     *
     * @return Amount of pages.
     */
    private int getPaginationAmount() {
        return Integer.parseInt(getDocument(Parser.DEFAULT_URL).select(PAGINATION).get(0).text());
    }

    private static Document getDocument(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * Main parser.
     * Gets: name, text and vacancy url.
     * Exclude java script, javascript. Takes only "java" names.
     * This year vacancies only.
     */
    public void parse() {
        int pages = getPaginationAmount();
        Document doc = null;
        for (int i = 1; i < pages; i++) {
            try {
                doc = Jsoup.connect(DEFAULT_URL + "/" + i)
                        .userAgent(USER_AGENT)
                        .referrer(REFERRER).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements nextPage = Objects.requireNonNull(doc).select(PAGE);
            for (Element headline : nextPage) {
                Elements date = headline.select(DATE);
                if (date.get(0).text().contains("сегодня")
                        || date.get(0).text().contains("вчера")
                        || date.get(0).text().split(" ")[2].equals("20,")
                ) {
                    String title = headline.select(TITLE).get(0).text().toLowerCase();
                    if (title.contains("java")
                            && !title.contains("javascript")
                            && !title.contains("java script")
                    ) {
                        String url = headline.select(LINK).get(0).absUrl("href");
                        String description = getDescription(url);
                        vacancySet.add(new Vacancy(title, description, url));
                    }
                } else {
                    pages = i;
                    break;
                }
            }
        }
    }

    /**
     * Get only "today" vacancies.
     */
    public void update() {
        Document doc = null;
        try {
            doc = Jsoup.connect(DEFAULT_URL + "/" + 1)
                    .userAgent(USER_AGENT)
                    .referrer(REFERRER).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements page = Objects.requireNonNull(doc).select(PAGE);
        for (Element headline : page) {
            Elements date = headline.select(DATE);
            if (date.get(0).text().contains("сегодня")) {
                String title = headline.select(TITLE).get(0).text().toLowerCase();
                if (title.contains("java")
                        && !title.contains("javascript")
                        && !title.contains("java script")
                ) {
                    String url = headline.select(LINK).get(0).absUrl("href");
                    String description = getDescription(url);
                    vacancySet.add(new Vacancy(title, description, url));
                }
            }
        }
    }
}
