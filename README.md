
**Notes**
- gli elementi nel contatore sono in chain; per cambiare la dimensione relativa agire su gravity,
  eventualmente aggiustare con padding dei singoli elementi

- la dimensione del fragment è definita secondo constraint da due guideline

- la textview comprende un padding che nella preview è leggermente sfasato più basso, ma su dispositivo,
  quando viene reso l'apice del metro cubo, dovrebbe riallinearsi alle altre
  proverò a sistemerlo meglio con questo appena ho un attimo, se funziona :
  https://stackoverflow.com/questions/45854413/constraintlayout-take-height-of-another-view-android

- per produrre l'apice uso Html.fromHtml la versione vecchia che funziona però è deprecata,
  quella nuova che ha in più un Int flag richiede minsSdk 24 e areaclienti ha il 23,
  lasciamo così poi vediamo, il peggio che può capitare è che non compaia come apice

