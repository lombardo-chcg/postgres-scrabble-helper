FROM postgres

ADD data/scrabble_dictionary.csv /scrabble_dictionary.csv
ADD sql/create_words_table.sql /docker-entrypoint-initdb.d/01_create_words_table.sql
ADD sql/seed_words_table.sql /docker-entrypoint-initdb.d/02_seed_words_table.sql
ADD sql/create_greetings_table.sql /docker-entrypoint-initdb.d/03_create_greetings_table.sql
ADD sql/seed_greetings_table.sql /docker-entrypoint-initdb.d/04_seed_greetings_table.sql
ADD sql/create_words_table_index.sql /docker-entrypoint-initdb.d/05_create_words_table_index.sql

EXPOSE 5342
