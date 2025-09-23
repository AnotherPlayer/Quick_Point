/**
 * This script sets up an incoming payment on a receiving wallet address,
 * and a quote on the sending wallet address (after getting grants for both of the resources).
 *
 * The final step is asking for an outgoing payment grant for the sending wallet address.
 * Since this needs user interaction, you will need to navigate to the URL, and accept the interactive grant.
 *
 * To start, please add the variables for configuring the client & the wallet addresses for the payment.
 */

import {
  createAuthenticatedClient,
  OpenPaymentsClientError,
  isFinalizedGrant
} from '@interledger/open-payments'
import readline from 'readline/promises'
;(async () => {
  // Client configuration
  const PRIVATE_KEY_PATH = 'private.key'
  const KEY_ID = '843f7807-651d-4a12-a8e6-7c048cab16df'

  // Make sure the wallet addresses starts with https:// (not $)
  const CLIENT_WALLET_ADDRESS_URL = 'https://ilp.interledger-test.dev/moremoney'
  const SENDING_WALLET_ADDRESS_URL = 'https://ilp.interledger-test.dev/vector'
  const RECEIVING_WALLET_ADDRESS_URL = 'https://ilp.interledger-test.dev/apocosi'

  const client = await createAuthenticatedClient({
    walletAddressUrl: CLIENT_WALLET_ADDRESS_URL,
    keyId: KEY_ID,
    privateKey: PRIVATE_KEY_PATH
  })

  // Step 1: Get the sending and receiving wallet addresses
  const sendingWalletAddress = await client.walletAddress.get({
    url: SENDING_WALLET_ADDRESS_URL
  })
  const receivingWalletAddress = await client.walletAddress.get({
    url: RECEIVING_WALLET_ADDRESS_URL
  })

  console.log('\nStep 1: got wallet addresses', {
    receivingWalletAddress,
    sendingWalletAddress
  })

  
})()