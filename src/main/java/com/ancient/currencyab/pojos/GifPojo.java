package com.ancient.currencyab.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GifPojo {
    private Data data;

    public GifPojo() {
    }

    @JsonCreator
    public GifPojo(@JsonProperty("data") Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private Image image;

        public Data() {
        }

        @JsonCreator
        public Data(@JsonProperty("images") Image image) {
            this.image = image;
        }

        public Image getImage() {
            return image;
        }

        public void setImage(Image image) {
            this.image = image;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Image {
            private GifUrl finUrl;

            public Image() {
            }

            @JsonCreator
            public Image(@JsonProperty("original") GifUrl finfinal) {
                this.finUrl = finfinal;
            }

            public GifUrl getUrl() {
                return finUrl;
            }

            public void setUrl(GifUrl finfinal) {
                this.finUrl = finfinal;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class GifUrl {
                private String finUrl;

                public GifUrl() {
                }

                @JsonCreator
                public GifUrl(@JsonProperty("url") String finurl) {
                    this.finUrl = finurl;
                }

                public String getFinUrl() {
                    return finUrl;
                }

                public void setFinUrl(String finUrl) {
                    this.finUrl = finUrl;
                }
            }
        }

    }
}
