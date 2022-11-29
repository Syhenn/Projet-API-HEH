CREATE TABLE IF NOT EXISTS beers (
  id SERIAL PRIMARY KEY,
  name varchar(50),
  url varchar(255),
  degrees real
    );