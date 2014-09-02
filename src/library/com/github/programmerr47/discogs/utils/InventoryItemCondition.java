package library.com.github.programmerr47.discogs.utils;

/**
 * @author Michael Spitsin
 * @since 2014-08-17
 */
public enum InventoryItemCondition {
    Mint(Constants.MINT),
    NearMint(Constants.NEAR_MINT),
    VeryGoodPlus(Constants.VERY_GOOD_PLUS),
    VeryGood(Constants.VERY_GOOD_PLUS),
    GoodPlus(Constants.GOOD_PLUS),
    Good(Constants.GOOD),
    Fair(Constants.FAIR),
    Poor(Constants.POOR);

    public static InventoryItemCondition getFromString(String strRepresentation) {
        if (strRepresentation == null) {
            return null;
        } else {
            if (strRepresentation.equals(Constants.MINT)) {
                return InventoryItemCondition.Mint;
            } else if (strRepresentation.equals(Constants.NEAR_MINT)) {
                return InventoryItemCondition.NearMint;
            } else if (strRepresentation.equals(Constants.VERY_GOOD_PLUS)) {
                return InventoryItemCondition.VeryGoodPlus;
            } else if (strRepresentation.equals(Constants.VERY_GOOD)) {
                return InventoryItemCondition.VeryGood;
            } else if (strRepresentation.equals(Constants.GOOD_PLUS)) {
                return InventoryItemCondition.GoodPlus;
            } else if (strRepresentation.equals(Constants.GOOD)) {
                return InventoryItemCondition.Good;
            } else if (strRepresentation.equals(Constants.FAIR)) {
                return InventoryItemCondition.Fair;
            } else if (strRepresentation.equals(Constants.POOR)) {
                return InventoryItemCondition.Poor;
            } else {
                return null;
            }
        }
    }

    private String mRepresentation;

    private InventoryItemCondition(String representation) {
        this.mRepresentation = representation;
    }

    public String toString() {
        return mRepresentation;
    }

    private static class Constants {
        private static final String MINT = "Mint (M)";
        private static final String NEAR_MINT = "Near Mint (NM or M-))";
        private static final String VERY_GOOD_PLUS = "Very Good Plus (VG+)";
        private static final String VERY_GOOD = "Very Good (VG)";
        private static final String GOOD_PLUS = "Good Plus (G+)";
        private static final String GOOD = "Good (G)";
        private static final String FAIR = "Fair (F)";
        private static final String POOR = "Poor (P)";
    }
}
