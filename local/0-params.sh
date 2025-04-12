#!/bin/sh

# This script sets up the environment for the local development of the project.

export PAYMENT_SQS_NAME="payment-update-queue"
export UPDATE_SQS_NAME="invoice-update-queue"
export ENDPOINT_URL="http://localhost:4566"
export PAYMENT_QUEUE_URL="$ENDPOINT_URL/000000000000/$PAYMENT_SQS_NAME"
export UPDATE_QUEUE_URL="$ENDPOINT_URL/000000000000/$UPDATE_SQS_NAME"
export QTT_TO_RECEIVE="10"
export MESSAGE_FILE_PATH="./message.json"

echo "###############################"
echo "#     IMPORTING VARIABLES     #"
echo "###############################"
echo "PAYMENT_SQS_NAME: $PAYMENT_SQS_NAME"
echo "UPDATE_SQS_NAME: $UPDATE_SQS_NAME"
echo "ENDPOINT_URL: $ENDPOINT_URL"
echo "PAYMENT_QUEUE_URL: $PAYMENT_QUEUE_URL"
echo "UPDATE_QUEUE_URL: $UPDATE_QUEUE_URL"
echo "QTT_TO_RECEIVE: $QTT_TO_RECEIVE"
echo "MESSAGE_FILE_PATH: $MESSAGE_FILE_PATH"