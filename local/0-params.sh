#!/bin/sh

# This script sets up the environment for the local development of the project.

export PAYMENT_UPDATE_SQS_NAME="payment-update-queue"
export INVOICE_UPDATE_SQS_NAME="invoice-update-queue"
export ENDPOINT_URL="http://localhost:4566"
export PAYMENT_UPDATE_QUEUE_URL="$ENDPOINT_URL/000000000000/$PAYMENT_UPDATE_SQS_NAME"
export INVOICE_UPDATE_QUEUE_URL="$ENDPOINT_URL/000000000000/$INVOICE_UPDATE_SQS_NAME"
export QTT_TO_RECEIVE="10"
export MESSAGE_FILE_PATH="./message.json"
export MESSAGE_LIST_FILE_PATH="./message_list.json"
export MESSAGE_ERROR_FILE_PATH="./message_error.json"

echo "###############################"
echo "#     IMPORTING VARIABLES     #"
echo "###############################"
echo "PAYMENT_UPDATE_SQS_NAME: $PAYMENT_UPDATE_SQS_NAME"
echo "INVOICE_UPDATE_SQS_NAME: $INVOICE_UPDATE_SQS_NAME"
echo "ENDPOINT_URL: $ENDPOINT_URL"
echo "PAYMENT_UPDATE_QUEUE_URL: $PAYMENT_UPDATE_QUEUE_URL"
echo "PINVOICE_UPDATE_QUEUE_URL: $INVOICE_UPDATE_QUEUE_URL"
echo "QTT_TO_RECEIVE: $QTT_TO_RECEIVE"
echo "MESSAGE_FILE_PATH: $MESSAGE_FILE_PATH"
echo "MESSAGE_ERROR_FILE_PATH: $MESSAGE_ERROR_FILE_PATH"