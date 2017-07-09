CREATE TABLE logs (
  id serial PRIMARY KEY,
  server_timestamp varchar(256) NOT NULL,
  user_request varchar(256) NOT NULL,
  user_agent varchar(256) NOT NULL,
  result_size integer NOT NULL,
  elapsed_time_ms integer NOT NULL,
  create_date timestamp NOT NULL default now()
);
