import {createAuthenticatedClient,OpenPaymentsClientError,isFinalizedGrant} from '@interledger/open-payments'
import readline from 'readline/promises';

(async () => {

    //Condiguración cliente
    const PRIVATE_KEY_PATH = 'private.key'
    const KEY_ID = '843f7807-651d-4a12-a8e6-7c048cab16df'

    const CLIENT_WALLET_ADDRESS_URL = 'https://ilp.interledger-test.dev/moremoney'
    const SENDING_WALLET_ADDRESS_URL = 'https://ilp.interledger-test.dev/vector'       //Obtener de Andrioid (QR)
    const RECEIVING_WALLET_ADDRESS_URL = 'https://ilp.interledger-test.dev/apocosi'     //Obtener de Andrioid (QR)

    const client = await createAuthenticatedClient({
        walletAddressUrl: CLIENT_WALLET_ADDRESS_URL,
        keyId: KEY_ID,
        privateKey: PRIVATE_KEY_PATH
    })
  
    //Caso del cliente

    //Obtener datos receptor/emisor
    const sendAddress = await client.walletAddress.get({
        url: SENDING_WALLET_ADDRESS_URL
    })

    const receiveAddress = await client.walletAddress.get({
        url: RECEIVING_WALLET_ADDRESS_URL
    })

    const incomingPaymentGrant = await client.grant.request({
      
        url: receivingWalletAddress.authServer

    },
    {
        access_token: {
            access: [{
        
        type: 'incoming-payment',
        actions: ['read', 'complete', 'create']
                }],
            }
        }
    )

    if (!isFinalizedGrant(incomingPaymentGrant))
        throw new Error('Expected finalized incoming payment grant')
    


    //Caso del vendedor


});

