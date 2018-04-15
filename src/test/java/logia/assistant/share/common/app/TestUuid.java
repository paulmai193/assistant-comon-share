package logia.assistant.share.common.app;

import logia.assistant.share.common.utils.UuidUtils;

public class TestUuid {

    public static void main(String[] args) {
        System.out.println(UuidUtils.generateUui(1L));
        System.out.println(UuidUtils.generateUui(10L));
        System.out.println(UuidUtils.generateUui(100L));
        System.out.println(UuidUtils.generateUui(9999L));
    }

}
