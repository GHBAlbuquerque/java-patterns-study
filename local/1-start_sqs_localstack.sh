#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#     STARTING LOCALSTACK     #"
echo "###############################"

docker-compose up -d --build

echo "###############################"
echo "#      CREATING QUEUE         #"
echo "###############################"

aws sqs create-queue \
  --queue-name "$PAYMENT_SQS_NAME" \
  --endpoint-url "$ENDPOINT_URL"

aws sqs create-queue \
  --queue-name "$UPDATE_SQS_NAME" \
  --endpoint-url "$ENDPOINT_URL"

echo "###############################"
echo "#        QUEUES CREATED       #"
echo "###############################"
read -p "Press enter to quit..."