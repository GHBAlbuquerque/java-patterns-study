#!/bin/sh

source "./0-params.sh"

echo "###############################"
echo "#       LISTING QUEUES        #"
echo "###############################"

aws sqs list-queues --endpoint-url "$ENDPOINT_URL"

echo "###############################"
echo "#       QUEUES LISTED        #"
echo "###############################"

read -p "Press enter to quit..."