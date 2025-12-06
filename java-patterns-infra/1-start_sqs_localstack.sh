#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#     STARTING LOCALSTACK     #"
echo "###############################"

docker-compose up -d --build

echo "###############################"
echo "#      CREATING QUEUES        #"
echo "###############################"

aws sqs create-queue \
  --queue-name "$PAYMENT_UPDATE_SQS_NAME" \
  --endpoint-url "$ENDPOINT_URL"

aws sqs create-queue \
  --queue-name "$INVOICE_UPDATE_SQS_NAME" \
  --endpoint-url "$ENDPOINT_URL"

echo "###############################"
echo "#       QUEUES CREATED        #"
echo "###############################"
read -p "Press enter to quit..."