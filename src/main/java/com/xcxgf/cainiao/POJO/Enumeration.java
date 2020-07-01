package com.xcxgf.cainiao.POJO;

/**
 * @author 田易
 */

public enum  Enumeration {

        /**
         * flags
         */
        flags(1,"1"),
        /**
         * years
         */
        years(1,"1"),
        /**
         * quarter
         */
        quarter(2,"2"),
        /**
         * month
         */
        month(3,"3"),
        /**
         * search
         */
        search(4,"房号");


        private int code;

        private String name;

    Enumeration(int code, String name){
            this.code = code;
            this.name = name;
        }

        /**
         * @return the code
         */
        public int getCode() {
            return code;
        }

        /**
         * @param code the code to set
         */
        public void setCode(int code) {
            this.code = code;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * 根据code值获取对应的枚举
         * @param code
         * @return
         */
        public static Enumeration getTypeByCode(int code){
            for(Enumeration type : Enumeration.values()){
                if(type.getCode() == code){
                    return type;
                }
            }

            throw new IllegalArgumentException("未能找到匹配的PayType:" + code);
        }
    }

