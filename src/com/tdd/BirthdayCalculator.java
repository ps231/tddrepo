package com.tdd;

public class BirthdayCalculator {

    private static final int UPPER_BOUND = 1000000000;
    private static final int LOWER_BOUND = 0;

    private final long noOfBlackGifts, noOfWhiteGifts, pricePerBlackGift, pricePerWhiteGift, priceOfConversion;

    public BirthdayCalculator(final long blackGifts, final long whiteGifts, final long priceOfBlackGift, final long priceOfWhiteGift, final long convPrice) {
        validateArguments(blackGifts, whiteGifts, priceOfBlackGift, priceOfWhiteGift, convPrice);

        this.noOfBlackGifts = blackGifts;
        this.noOfWhiteGifts = whiteGifts;
        this.pricePerBlackGift = priceOfBlackGift;
        this.pricePerWhiteGift = priceOfWhiteGift;
        this.priceOfConversion = convPrice;
    }

    private void validateArguments(final long blackGifts, final long whiteGifts, final long priceOfBlackGift, final long priceOfWhiteGift, final long convPrice) {
        validate(blackGifts, whiteGifts, priceOfBlackGift, priceOfWhiteGift, convPrice);
    }

    private void validate(final long... args) {
        for (final long arg : args) {
            if (arg < LOWER_BOUND || arg > UPPER_BOUND) {
                throw new IllegalArgumentException("argument must be within 0 to 1000000000 range");
            }
        }

    }

    public long getNoOfBlackGifts() {
        return noOfBlackGifts;
    }

    public long getNoOfWhiteGifts() {
        return noOfWhiteGifts;
    }

    public long getPricePerBlackGift() {
        return pricePerBlackGift;
    }

    public long getPricePerWhiteGift() {
        return pricePerWhiteGift;
    }

    public long getPriceOfConversion() {
        return priceOfConversion;
    }

    public long deduceMinAmountToBeSpent() {
        long minAmount = 0L;
        if (isBenefitInConversion()) {
            if (isPriceOfBlackMoreThanPriceOfConversion()) {
                minAmount += calculateAmount(noOfWhiteGifts, pricePerWhiteGift);
                minAmount += calculateConvertedPrice(noOfBlackGifts, pricePerWhiteGift, priceOfConversion);
            } else if (isPriceOfWhiteMoreThanPriceOfConversion()) {
                minAmount += calculateAmount(noOfBlackGifts, pricePerBlackGift);
                minAmount += calculateConvertedPrice(noOfWhiteGifts, pricePerBlackGift, priceOfConversion);
            } else {
                minAmount += calculateAmount(noOfBlackGifts, pricePerBlackGift);
                minAmount += calculateAmount(noOfWhiteGifts, pricePerWhiteGift);
            }
        } else {
            minAmount += calculateAmount(noOfBlackGifts, pricePerBlackGift);
            minAmount += calculateAmount(noOfWhiteGifts, pricePerWhiteGift);
        }
        return minAmount;
    }

    private boolean isPriceOfWhiteMoreThanPriceOfConversion() {
        return (pricePerWhiteGift > pricePerBlackGift + priceOfConversion);
    }

    private long calculateConvertedPrice(final long noOfGifts, final long pricePerGift, final long priceOfConversion) {
        return (noOfGifts * pricePerGift + noOfGifts * priceOfConversion);
    }

    private boolean isPriceOfBlackMoreThanPriceOfConversion() {
        return (pricePerBlackGift > pricePerWhiteGift + priceOfConversion);
    }

    private long calculateAmount(final long noOfGifts, final long pricePerGift) {
        return noOfGifts * pricePerGift;
    }

    private boolean isBenefitInConversion() {
        return !(areAllGiftPricesSame() || areConvPricesSameAsSingleGiftPrice() || isConvPriceMoreThanSingleGiftPrice());
    }

    private boolean isConvPriceMoreThanSingleGiftPrice() {
        return pricePerBlackGift < priceOfConversion && pricePerWhiteGift < priceOfConversion;
    }

    private boolean areConvPricesSameAsSingleGiftPrice() {
        return Math.abs(pricePerBlackGift - pricePerWhiteGift) == priceOfConversion;
    }

    private boolean areAllGiftPricesSame() {
        return pricePerBlackGift == pricePerWhiteGift && pricePerWhiteGift == priceOfConversion;
    }

}
