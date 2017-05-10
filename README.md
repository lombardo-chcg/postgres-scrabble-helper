# Postgres Scrabble Helper

A Dockerized Postgres DB with a Scrabble helper table.

Query the table using a group of letters arranged in alphabetical order.

Returns all words that match your letters along with baseline Scrabble points (before any bonus squares)

## Get Started
```
git clone https://github.com/lombardo-chcg/postgres-scrabble-helper.git
cd postgres-scrabble-helper
```

## Example Usage
```
docker-compose up

# when you see 'PostgreSQL init process complete; ready for start up.' open a new terminal

docker exec -it postgres-scrabble-helper psql -U postgres

\connect scrabble_helper;
select * from words where canonical_word='abbcelrs';

#    id   |   word   | canonical_word | points |        create_date   
# --------+----------+----------------+--------+----------------------------
#   27273 | clabbers | abbcelrs       |     14 | 2017-05-10 00:07:24.593537
#  139275 | scrabble | abbcelrs       |     14 | 2017-05-10 00:07:24.593537
```

## Build a Docker Image
```
docker build -t postgres-scrabble-helper .
```
