(
    (
        (
            (Country_vod__c like '%a%')
                AND (Not Email_vod__c like '%b%')
            )
            AND (City_vod__c = 'c')
            AND (Name != 'd')
        )
        OR (Address_Line_1_vod__c < 'e')
)
AND (
  (Address_Line_1_vod__c > 'f')
  AND (Address_Line_2_vod__c <= 'g')
)
AND (Call2_vod__r.Name >= 'h')
AND (City_vod__c like 'i%')
