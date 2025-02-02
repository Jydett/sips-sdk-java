package com.worldline.sips.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.worldline.sips.exception.UnknownStatusException;

public enum WalletResponseCode {
  /**
   * Successful operation
   */
  SUCCESS("00"),
  /**
   * Invalid Merchant contract
   */
  INVALID_MERCHANT("03"),
  /**
   * Invalid data, verify the request
   */
  INVALID_DATA("12"),
  /**
   * Wallet / payment mean unknown by WL Sips
   */
  UNKNOWN_WALLET("25"),
  FORMAT_ERROR("30"),
  /**
   * MerchantId not allowed to access this wallet service
   */
  NOT_ALLOWED("40"),
  /**
   * Duplicated wallet / payment mean
   */
  ALREADY_PRESENT("94"),
  /**
   * Temporary problem at the WL Sips server level
   */
  INTERNAL_TEMPORARY_PROBLEM("99")
  ;

  private final String code;

  @JsonCreator
  public static WalletResponseCode fromCode(String code) throws UnknownStatusException {
    for (WalletResponseCode responseCode : WalletResponseCode.values()) {
      if (responseCode.getCode().equals(code)) {
        return responseCode;
      }
    }

    throw new UnknownStatusException(code + " is an unknown response code!");
  }

  @JsonValue
  public String getCode() {
    return code;
  }


  WalletResponseCode(String code) {
    this.code = code;
  }
}
