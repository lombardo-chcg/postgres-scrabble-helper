FROM postgres

ADD data/scrabble_dictionary.csv /scrabble_dictionary.csv
ADD sql/create_words_table.sql /docker-entrypoint-initdb.d/create_words_table.sql
ADD sql/seed_words_table.sql /docker-entrypoint-initdb.d/seed_words_table.sql
ADD sql/create_greetings_table.sql /docker-entrypoint-initdb.d/create_greetings_table.sql
ADD sql/seed_greetings_table.sql /docker-entrypoint-initdb.d/seed_greetings_table.sql

EXPOSE 5342
