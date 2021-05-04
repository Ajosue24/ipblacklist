docker build -t "ipblacklist" .
docker-compose up -d
docker logs -f --tail 5 ipblacklist