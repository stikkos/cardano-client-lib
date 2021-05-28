package com.bloxbean.cardano.client.backend.api.helper;

import com.bloxbean.cardano.client.backend.exception.ApiException;
import com.bloxbean.cardano.client.backend.model.Utxo;
import com.bloxbean.cardano.client.exception.AddressExcepion;
import com.bloxbean.cardano.client.metadata.Metadata;
import com.bloxbean.cardano.client.transaction.model.MintTransaction;
import com.bloxbean.cardano.client.transaction.model.PaymentTransaction;
import com.bloxbean.cardano.client.transaction.model.TransactionDetailsParams;
import com.bloxbean.cardano.client.transaction.spec.Transaction;

import java.math.BigInteger;
import java.util.List;

public interface UtxoTransactionBuilder {
    /**
     * Set utxo selection strategy
     * @param utxoSelectionStrategy
     */
    void setUtxoSelectionStrategy(UtxoSelectionStrategy utxoSelectionStrategy);

    /**
     * Build Transaction for list of Payment Transactions
     * @param transactions
     * @param detailsParams
     * @param metadata
     * @return
     * @throws ApiException
     * @throws AddressExcepion
     */
    Transaction buildTransaction(List<PaymentTransaction> transactions, TransactionDetailsParams detailsParams, Metadata metadata) throws ApiException,
            AddressExcepion;

    /**
     * Get required utxos by address, unit and amount
     * @param address
     * @param unit
     * @param amount
     * @return
     * @throws ApiException
     */
    List<Utxo> getUtxos(String address, String unit, BigInteger amount) throws ApiException;

    /**
     * Build Transaction for token minting
     * @param mintTransaction
     * @param detailsParams
     * @param metadata
     * @return
     * @throws ApiException
     * @throws AddressExcepion
     */
    Transaction buildMintTokenTransaction(MintTransaction mintTransaction, TransactionDetailsParams detailsParams, Metadata metadata) throws ApiException, AddressExcepion;
}
