CREATE TABLE IF NOT EXISTS beers (
  id SERIAL PRIMARY KEY,
  nameBeer varchar(15),
  url varchar(255),
  degrees real
    );