package library.com.github.programmerr47.discogs.utils;

/**
 * @author Michael Spitsin
 * @since 2014-08-17
 */
public enum InventoryItemSleeveCondition {
    Mint(Constants.MINT),
    NearMint(Constants.NEAR_MINT),
    VeryGoodPlus(Constants.VERY_GOOD_PLUS),
    VeryGood(Constants.VERY_GOOD_PLUS),
    GoodPlus(Constants.GOOD_PLUS),
    Good(Constants.GOOD),
    Fair(Constants.FAIR),
    Poor(Constants.POOR),
    Generic(Constants.GENERIC),
    NotGraded(Constants.NOT_GRADED),
    NoCover(Constants.NO_COVER);

    public static InventoryItemSleeveCondition getFromString(String strRepresentation) {
        if (strRepresentation == null) {
            return null;
        } else {
            if (strRepresentation.equals(Constants.MINT)) {
                return InventoryItemSleeveCondition.Mint;
            } else if (strRepresentation.equals(Constants.NEAR_MINT)) {
                return InventoryItemSleeveCondition.NearMint;
            } else if (strRepresentation.equals(Constants.VERY_GOOD_PLUS)) {
                return InventoryItemSleeveCondition.VeryGoodPlus;
            } else if (strRepresentation.equals(Constants.VERY_GOOD)) {
                return InventoryItemSleeveCondition.VeryGood;
            } else if (strRepresentation.equals(Constants.GOOD_PLUS)) {
                return InventoryItemSleeveCondition.GoodPlus;
            } else if (strRepresentation.equals(Constants.GOOD)) {
                return InventoryItemSleeveCondition.Good;
            } else if (strRepresentation.equals(Constants.FAIR)) {
                return InventoryItemSleeveCondition.Fair;
            } else if (strRepresentation.equals(Constants.POOR)) {
                return InventoryItemSleeveCondition.Poor;
            } else if (strRepresentation.equals(Constants.GENERIC)) {
                return InventoryItemSleeveCondition.Generic;
            } else if (strRepresentation.equals(Constants.NOT_GRADED)) {
                return InventoryItemSleeveCondition.NotGraded;
            } else if (strRepresentation.equals(Constants.NO_COVER)) {
                return InventoryItemSleeveCondition.NoCover;
            } else {
                return null;
            }
        }
    }

    private String mRepresentation;

    private InventoryItemSleeveCondition(String representation) {
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
        private static final String GENERIC = "Generic";
        private static final String NOT_GRADED = "Not Graded";
        private static final String NO_COVER = "No Cover";
    }
}
