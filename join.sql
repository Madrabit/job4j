SELECT * FROM car;
SELECT * FROM car right outer join body on body_id = body.id where car.id is null;
SELECT * FROM car right outer join engine on engine_id = engine.id where car.id is null;
SELECT * FROM car right outer join transmission on transmission_id = transmission.id where car.id is null;
