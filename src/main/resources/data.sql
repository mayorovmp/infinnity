CREATE TABLE City (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    NAME VARCHAR(250) NOT NULL
);

CREATE TABLE Weather (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    timestamp TIMESTAMP NOT NULL,
    value DOUBLE NOT NULL,
    city_id INT NOT NULL,
    FOREIGN KEY (city_id) references City(id)
);

create index Weather_city_id_timestamp_index
    on Weather (city_id, timestamp);
