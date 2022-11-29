CREATE TABLE IF NOT EXISTS wines  (
  id SERIAL PRIMARY KEY,
  nameWine varchar(50),
  url varchar(255),
  degrees real
    );