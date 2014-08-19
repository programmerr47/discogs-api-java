package library.com.github.programmerr47.discogs.utils;

/**
 * @author Michael Spitsin
 * @since 2014-08-17
 */
public enum InventoryItemSleeveCondition {
    Mint,
    NearMint,
    VeryGoodPlus,
    VeryGood,
    GoodPlus,
    Good,
    Fair,
    Poor,
    Generic,
    NotGraded,
    NoCover;

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

    public static InventoryItemSleeveCondition getFromString(String strRepresentation) {
        if (strRepresentation == null) {
            return null;
        } else {
            if (strRepresentation.equals(MINT)) {
                return InventoryItemSleeveCondition.Mint;
            } else if (strRepresentation.equals(NEAR_MINT)) {
                return InventoryItemSleeveCondition.NearMint;
            } else if (strRepresentation.equals(VERY_GOOD_PLUS)) {
                return InventoryItemSleeveCondition.VeryGoodPlus;
            } else if (strRepresentation.equals(VERY_GOOD)) {
                return InventoryItemSleeveCondition.VeryGood;
            } else if (strRepresentation.equals(GOOD_PLUS)) {
                return InventoryItemSleeveCondition.GoodPlus;
            } else if (strRepresentation.equals(GOOD)) {
                return InventoryItemSleeveCondition.Good;
            } else if (strRepresentation.equals(FAIR)) {
                return InventoryItemSleeveCondition.Fair;
            } else if (strRepresentation.equals(POOR)) {
                return InventoryItemSleeveCondition.Poor;
            } else if (strRepresentation.equals(GENERIC)) {
                return InventoryItemSleeveCondition.Generic;
            } else if (strRepresentation.equals(NOT_GRADED)) {
                return InventoryItemSleeveCondition.NotGraded;
            } else if (strRepresentation.equals(NO_COVER)) {
                return InventoryItemSleeveCondition.NoCover;
            } else {
                return null;
            }
        }
    }
}
