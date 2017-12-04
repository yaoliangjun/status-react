(ns status-im.ui.screens.wallet.settings.subs
  (:require [re-frame.core :as re-frame]
            [status-im.utils.ethereum.core :as ethereum]))

;; A set of visible-tokens for current network
(re-frame/reg-sub :wallet.settings/visible-tokens
  (fn [{:keys [network] :as db}]
    (let [chain-id (ethereum/network->chain-id network)]
      (get-in db [:wallet :settings :visible-tokens chain-id]))))