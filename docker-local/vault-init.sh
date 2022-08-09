echo "Vault initializing secrets"

vault auth 00000000-0000-0000-0000-000000000000

vault write secret/btc \
                oauth2.client-id=87f48948-abce-4882-9882-1cd543b2979b \
                oauth2.client-secret=tQCMnkPARaiXvZLP \
                redis.host=redis \
                redis.port=6379 \
                redis.password=12345 \
                encrypt.password=juk \
                encrypt.salt=b61ee22d22554ad0