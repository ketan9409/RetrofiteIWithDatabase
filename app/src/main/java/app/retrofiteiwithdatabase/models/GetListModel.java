package app.retrofiteiwithdatabase.models;

import java.util.List;

/**
 * Created by ketan on 7/7/17.
 */

public class GetListModel {


    /**
     * IsLastPage : false
     * Content : [{"ID":12793,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-07-06T14:14:22.163","Title":"Trade Result EUR/USD","ExpireDate":"2017-07-06T14:14:22.157","TradeResult":0.01,"Sticky":false,"Viewed":0,"Link":null,"ThumbNailIcon":""},{"ID":12792,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-07-06T13:10:11.167","Title":"Trade Result EUR/USD","ExpireDate":"2017-07-06T13:10:11.16","TradeResult":0,"Sticky":false,"Viewed":0,"Link":null,"ThumbNailIcon":""},{"ID":12787,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-07-05T08:44:42.38","Title":"Trade Update Crude Oil","ExpireDate":"0001-01-01T00:00:00","TradeResult":0,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12785,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-29T13:57:30","Title":"Trade Result Natural Gas","ExpireDate":"2017-06-29T13:57:29.997","TradeResult":0.06,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12784,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-29T09:13:58.967","Title":"Trade Result GBP/USD","ExpireDate":"2017-06-29T09:13:58.933","TradeResult":0.02,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12781,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-27T13:38:44.7","Title":"Trade Result EUR/USD","ExpireDate":"2017-06-27T13:38:44.697","TradeResult":-0.2,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12779,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-22T18:01:01.637","Title":"Trade Result S&P 500","ExpireDate":"2017-06-22T18:01:01.617","TradeResult":0.04,"Sticky":false,"Viewed":0,"Link":null,"ThumbNailIcon":""},{"ID":12777,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-19T13:58:57.213","Title":"Trade Result S&P 500","ExpireDate":"2017-06-19T13:58:57.207","TradeResult":0.04,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12774,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-13T12:57:04.157","Title":"Trade Result Gold","ExpireDate":"2017-06-13T12:57:04.153","TradeResult":0.04,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12772,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-09T14:13:10.237","Title":"Trade Result S&P 500","ExpireDate":"2017-06-09T14:13:10.23","TradeResult":0.12,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12771,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-09T09:44:17.73","Title":"Trade Result EUR/USD","ExpireDate":"2017-06-09T09:44:17.723","TradeResult":-0.1,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12770,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-09T09:43:58.96","Title":"Trade Result Gold","ExpireDate":"2017-06-09T09:43:58.953","TradeResult":-0.1,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12766,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-06-07T14:41:34.573","Title":"Trade Result S&P 500","ExpireDate":"2017-06-07T14:41:34.567","TradeResult":0,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12764,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-06-02T12:36:05.577","Title":"Trade Result EUR/USD","ExpireDate":"2017-06-02T12:36:05.56","TradeResult":0.1,"Sticky":false,"Viewed":0,"Link":null,"ThumbNailIcon":""},{"ID":12762,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-06-01T10:08:48.43","Title":"Trade Result EUR/USD","ExpireDate":"2017-06-01T10:08:48.423","TradeResult":0,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12760,"IsPremium":false,"TypeID":12,"Author":"","OpenDate":"2017-05-31T14:10:24.353","Title":"Trade Result USD/JPY","ExpireDate":"2017-05-31T14:10:24.34","TradeResult":0.04,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12758,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-05-30T07:37:15.427","Title":"Trade Result USD/JPY","ExpireDate":"2017-05-30T07:37:15.42","TradeResult":0,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12757,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-05-30T07:10:45.207","Title":"Trade Result S&P 500","ExpireDate":"2017-05-30T07:10:45.197","TradeResult":0,"Sticky":false,"Viewed":0,"Link":null,"ThumbNailIcon":""},{"ID":12754,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-05-25T13:12:15.117","Title":"New Trade S&P 500","ExpireDate":"0001-01-01T00:00:00","TradeResult":0,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""},{"ID":12753,"IsPremium":true,"TypeID":12,"Author":"","OpenDate":"2017-05-24T12:12:00.673","Title":"New Trade S&P 500","ExpireDate":"0001-01-01T00:00:00","TradeResult":0,"Sticky":false,"Viewed":1,"Link":null,"ThumbNailIcon":""}]
     * ReturnValue : 1
     * Errors : []
     */

    private boolean IsLastPage;
    private int ReturnValue;
    private List<ContentBean> Content;
    private List<?> Errors;

    public boolean isIsLastPage() {
        return IsLastPage;
    }

    public void setIsLastPage(boolean IsLastPage) {
        this.IsLastPage = IsLastPage;
    }

    public int getReturnValue() {
        return ReturnValue;
    }

    public void setReturnValue(int ReturnValue) {
        this.ReturnValue = ReturnValue;
    }

    public List<ContentBean> getContent() {
        return Content;
    }

    public void setContent(List<ContentBean> Content) {
        this.Content = Content;
    }

    public List<?> getErrors() {
        return Errors;
    }

    public void setErrors(List<?> Errors) {
        this.Errors = Errors;
    }

    public static class ContentBean {
        /**
         * ID : 12793
         * IsPremium : false
         * TypeID : 12
         * Author :
         * OpenDate : 2017-07-06T14:14:22.163
         * Title : Trade Result EUR/USD
         * ExpireDate : 2017-07-06T14:14:22.157
         * TradeResult : 0.01
         * Sticky : false
         * Viewed : 0
         * Link : null
         * ThumbNailIcon :
         */

        private int ID;
        private boolean IsPremium;
        private int TypeID;
        private String Author;
        private String OpenDate;
        private String Title;
        private String ExpireDate;
        private double TradeResult;
        private boolean Sticky;
        private int Viewed;
        private Object Link;
        private String ThumbNailIcon;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public boolean isIsPremium() {
            return IsPremium;
        }

        public void setIsPremium(boolean IsPremium) {
            this.IsPremium = IsPremium;
        }

        public int getTypeID() {
            return TypeID;
        }

        public void setTypeID(int TypeID) {
            this.TypeID = TypeID;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String Author) {
            this.Author = Author;
        }

        public String getOpenDate() {
            return OpenDate;
        }

        public void setOpenDate(String OpenDate) {
            this.OpenDate = OpenDate;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getExpireDate() {
            return ExpireDate;
        }

        public void setExpireDate(String ExpireDate) {
            this.ExpireDate = ExpireDate;
        }

        public double getTradeResult() {
            return TradeResult;
        }

        public void setTradeResult(double TradeResult) {
            this.TradeResult = TradeResult;
        }

        public boolean isSticky() {
            return Sticky;
        }

        public void setSticky(boolean Sticky) {
            this.Sticky = Sticky;
        }

        public int getViewed() {
            return Viewed;
        }

        public void setViewed(int Viewed) {
            this.Viewed = Viewed;
        }

        public Object getLink() {
            return Link;
        }

        public void setLink(Object Link) {
            this.Link = Link;
        }

        public String getThumbNailIcon() {
            return ThumbNailIcon;
        }

        public void setThumbNailIcon(String ThumbNailIcon) {
            this.ThumbNailIcon = ThumbNailIcon;
        }
    }

}
