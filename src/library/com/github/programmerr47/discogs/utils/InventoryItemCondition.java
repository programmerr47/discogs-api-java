package library.com.github.programmerr47.discogs.utils;

/**
 * @author Michael Spitsin
 * @since 2014-08-17
 */
public enum InventoryItemCondition {
    Mint,
    NearMint,
    VeryGoodPlus,
    VeryGood,
    GoodPlus,
    Good,
    Fair,
    Poor;

    private static final String MINT = "Mint (M)";
    private static final String NEAR_MINT = "Near Mint (NM or M-))";
    private static final String VERY_GOOD_PLUS = "Very Good Plus (VG+)";
    private static final String VERY_GOOD = "Very Good (VG)";
    private static final String GOOD_PLUS = "Good Plus (G+)";
    private static final String GOOD = "Good (G)";
    private static final String FAIR = "Fair (F)";
    private static final String POOR = "Poor (P)";

    public static InventoryItemCondition getFromString(String strRepresentation) {
        if (strRepresentation == null) {
            return null;
        } else {
            if (strRepresentation.equals(MINT)) {
                return InventoryItemCondition.Mint;
            } else if (strRepresentation.equals(NEAR_MINT)) {
                return InventoryItemCondition.NearMint;
            } else if (strRepresentation.equals(VERY_GOOD_PLUS)) {
                return InventoryItemCondition.VeryGoodPlus;
            } else if (strRepresentation.equals(VERY_GOOD)) {
                return InventoryItemCondition.VeryGood;
            } else if (strRepresentation.equals(GOOD_PLUS)) {
                return InventoryItemCondition.GoodPlus;
            } else if (strRepresentation.equals(GOOD)) {
                return InventoryItemCondition.Good;
            } else if (strRepresentation.equals(FAIR)) {
                return InventoryItemCondition.Fair;
            } else if (strRepresentation.equals(POOR)) {
                return InventoryItemCondition.Poor;
            } else {
                return null;
            }
        }
    }
}
