#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#      DELETING MESSAGES      #"
echo "###############################"

aws sqs purge-queue --endpoint-url "$ENDPOINT_URL" \
  --queue-url "$PAYMENT_QUEUE_URL"

echo "###############################"
echo "#      MESSAGES DELETED       #"
echo "###############################"

read -p "Press enter to quit..."