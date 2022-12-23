# Invoicing test assignment

Java command line app for calculating invoices from given document

## Usage

### Once compiled application will prompt you to give needed information:

- Currency rates (required) - comma separated list of currencies and their rates
- Output currency (required) - output currenct in ISO 4217 format
- CSV file name (required) - name of file, containing documents for calculation
- Vat number filtering (optional) - calculate document only per given VAT number

### Example rates format:

```
rates: EUR:1,GBP:1.9,USD:0.8
```