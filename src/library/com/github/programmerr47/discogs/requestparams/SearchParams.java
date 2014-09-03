package library.com.github.programmerr47.discogs.requestparams;

import library.com.github.programmerr47.discogs.utils.SearchType;

/**
 * Class for representing search params in Discogs search requests.
 * <strong>See:</strong> http://www.discogs.com/developers/#page:database,header:database-search-get
 *
 * @author Michael Spitsin
 * @since 2014-08-15
 */
@SuppressWarnings("unused")
public class SearchParams extends PaginationParams{
    private static final String SEARCH_QUERY_PARAM_NAME = "query";
    private static final String TYPE_PARAM_NAME = "type";
    private static final String TITLE_PARAM_NAME = "title";
    private static final String RELEASE_TITLE_PARAM_NAME = "release_title";
    private static final String RELEASE_CREDIT_PARAM_NAME = "credit";
    private static final String ARTIST_TITLE_PARAM_NAME = "artist";
    private static final String ARTIST_ANV_PARAM_NAME = "anv";
    private static final String LABEL_TITLE_PARAM_NAME = "label";
    private static final String GENRE_TITLE_PARAM_NAME = "genre";
    private static final String STYLE_QUERY_PARAM_NAME = "style";
    private static final String RELEASE_COUNTRY_PARAM_NAME = "country";
    private static final String RELEASE_YEAR_PARAM_NAME = "year";
    private static final String FORMAT_PARAM_NAME = "format";
    private static final String CATALOG_NUMBER_PARAM_NAME = "catno";
    private static final String BARCODE_PARAM_NAME = "barcode";
    private static final String TRACK_TITLE_PARAM_NAME = "track";
    private static final String SUBMITTER_PARAM_NAME = "submitter";
    private static final String CONTRIBUTOR_PARAM_NAME = "contributor";

    private String searchQuery;
    private SearchType type;
    private String title;
    private String releaseTitle;
    private String releaseCredit;
    private String artistTitle;
    private String artistANV;
    private String labelTitle;
    private String genreTitle;
    private String styleTitle;
    private String releaseCountry;
    private String releaseYear;
    private String format;
    private String catalogNumber;
    private String barcode;
    private String track;
    private String submitter;
    private String contributor;

    protected SearchParams(Builder builder) {
        super(builder);
        this.searchQuery = builder.searchQuery;
        this.type = builder.type;
        this.title = builder.title;
        this.releaseTitle = builder.releaseTitle;
        this.releaseCredit = builder.releaseCredit;
        this.artistTitle = builder.artistTitle;
        this.artistANV = builder.artistANV;
        this.labelTitle = builder.labelTitle;
        this.genreTitle = builder.genreTitle;
        this.styleTitle = builder.styleTitle;
        this.releaseCountry = builder.releaseCountry;
        this.releaseYear = builder.releaseYear;
        this.format = builder.format;
        this.catalogNumber = builder.catalogNumber;
        this.barcode = builder.barcode;
        this.track = builder.track;
        this.submitter = builder.submitter;
        this.contributor = builder.contributor;
    }

    @Override
    public String getQuery() {
        StringBuilder result = new StringBuilder(super.getQuery());

        ParamUtils.addIntegerParameterIfNeed(result, SEARCH_QUERY_PARAM_NAME, searchQuery);
        ParamUtils.addIntegerParameterIfNeed(result, TYPE_PARAM_NAME, type);
        ParamUtils.addIntegerParameterIfNeed(result, TITLE_PARAM_NAME, title);
        ParamUtils.addIntegerParameterIfNeed(result, RELEASE_TITLE_PARAM_NAME, releaseTitle);
        ParamUtils.addIntegerParameterIfNeed(result, RELEASE_CREDIT_PARAM_NAME, releaseCredit);
        ParamUtils.addIntegerParameterIfNeed(result, ARTIST_TITLE_PARAM_NAME, artistTitle);
        ParamUtils.addIntegerParameterIfNeed(result, ARTIST_ANV_PARAM_NAME, artistANV);
        ParamUtils.addIntegerParameterIfNeed(result, LABEL_TITLE_PARAM_NAME, labelTitle);
        ParamUtils.addIntegerParameterIfNeed(result, GENRE_TITLE_PARAM_NAME, genreTitle);
        ParamUtils.addIntegerParameterIfNeed(result, STYLE_QUERY_PARAM_NAME, styleTitle);
        ParamUtils.addIntegerParameterIfNeed(result, RELEASE_COUNTRY_PARAM_NAME, releaseCountry);
        ParamUtils.addIntegerParameterIfNeed(result, RELEASE_YEAR_PARAM_NAME, releaseYear);
        ParamUtils.addIntegerParameterIfNeed(result, FORMAT_PARAM_NAME, format);
        ParamUtils.addIntegerParameterIfNeed(result, CATALOG_NUMBER_PARAM_NAME, catalogNumber);
        ParamUtils.addIntegerParameterIfNeed(result, BARCODE_PARAM_NAME, barcode);
        ParamUtils.addIntegerParameterIfNeed(result, TRACK_TITLE_PARAM_NAME, track);
        ParamUtils.addIntegerParameterIfNeed(result, SUBMITTER_PARAM_NAME, submitter);
        ParamUtils.addIntegerParameterIfNeed(result, CONTRIBUTOR_PARAM_NAME, contributor);

        return ParamUtils.removeFirstCharacterIfDelimiter(result.toString());
    }

    public static class Builder extends PaginationParams.Builder {
        private String searchQuery;
        private SearchType type;
        private String title;
        private String releaseTitle;
        private String releaseCredit;
        private String artistTitle;
        private String artistANV;
        private String labelTitle;
        private String genreTitle;
        private String styleTitle;
        private String releaseCountry;
        private String releaseYear;
        private String format;
        private String catalogNumber;
        private String barcode;
        private String track;
        private String submitter;
        private String contributor;

        @SuppressWarnings("unused")
        public Builder setSearchQuery(String searchQuery) {
            this.searchQuery = searchQuery;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setType(SearchType type) {
            this.type = type;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setReleaseTitle(String releaseTitle) {
            this.releaseTitle = releaseTitle;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setReleaseCredit(String releaseCredit) {
            this.releaseCredit = releaseCredit;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setArtistTitle(String artistTitle) {
            this.artistTitle = artistTitle;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setArtistANV(String artistANV) {
            this.artistANV = artistANV;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setLabelTitle(String labelTitle) {
            this.labelTitle = labelTitle;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setGenreTitle(String genreTitle) {
            this.genreTitle = genreTitle;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setStyleTitle(String styleTitle) {
            this.styleTitle = styleTitle;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setReleaseCountry(String releaseCountry) {
            this.releaseCountry = releaseCountry;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setReleaseYear(String releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setFormat(String format) {
            this.format = format;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setCatalogNumber(String catalogNumber) {
            this.catalogNumber = catalogNumber;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setBarcode(String barcode) {
            this.barcode = barcode;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setTrack(String track) {
            this.track = track;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setSubmitter(String submitter) {
            this.submitter = submitter;
            return this;
        }

        @SuppressWarnings("unused")
        public Builder setContributor(String contributor) {
            this.contributor = contributor;
            return this;
        }

        @Override
        public Builder setCurrentPage(int currentPage) {
            return (Builder) super.setCurrentPage(currentPage);
        }

        @Override
        public Builder setItemCountPerPage(int itemCountPerPage) {
            return (Builder) super.setItemCountPerPage(itemCountPerPage);
        }
        
        public SearchParams build() {
            return new SearchParams(this);
        }
    }
}
