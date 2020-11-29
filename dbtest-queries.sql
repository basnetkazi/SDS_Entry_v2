--1) Find total claimed_charge of the exported documents.
SELECT SUM(CLAIMED_CHARGE)
FROM DOCUMENT;
--Result:97970


--2) Find insured_name, insured_address and claimed_charge for the documents that have status "TO_REPRICE" and customer id 1 and 2.
SELECT INSURED_NAME
	,INSURED_ADDRESS
	,CLAIMED_CHARGE
FROM DOCUMENT
INNER JOIN BATCH ON (BATCH.ID = DOCUMENT.BATCH_ID)
WHERE BATCH.CUSTOMER_ID IN (
		'1'
		,'2'
		)
	AND BATCH.STATUS like 'TO_REPRICE';
--No Rows returned as there is no any tuples with Batch.Status as 'TO_REPRICE'