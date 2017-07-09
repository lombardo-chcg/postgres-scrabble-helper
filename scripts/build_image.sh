tag=${1:-latest}

imageID=$(docker build -q .)

docker build -t my_docker_image:$tag .

echo "docker image created: lombardo/postgres-scrabble-helper:$tag"
