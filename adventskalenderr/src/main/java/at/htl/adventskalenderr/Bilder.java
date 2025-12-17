package at.htl.adventskalenderr;

public enum Bilder {
    t1("/images/gabenewellsanta.jpg"),
    t2("/images/terryamrauchn.gif"),
    t3("/images/terryxmas.jpg"),
    t4("/images/tuxxmassanta.jpg"),
    t5("/images/templeosxmas.jpg"),
    t6("/images/santasfavlinuxwizard.jpg"),
    t7("/images/christmas-cats.gif"),
    t8("/images/jumping-cat-christmas.gif"),
    t9("/images/terry-dancing.gif"),
    t10("/images/bunnychristmas.gif"),
    t11("/images/gabenewellxmas.jpg"),
    t12("/images/linusmerkelpose.jpg"),
    t13("/images/placeholderimg.png"),
    t14("/images/gabesantaselfmade.jpg"),
    t15("/images/placeholderimg.png"),
    t16("/images/linustorvalds.jpg"),
    t17("/images/placeholderimg.png"),
    t18("/images/tux-merry-christmas.gif"),
    t19("/images/terrydaviscover.jpg"),
    t20("/images/placeholderimg.png"),
    t21("/images/placeholderimg.png"),
    t22("/images/linux-linus.gif"),
    t23("/images/placeholderimg.png"),
    t24("/images/evilfloatingpointmagic.png");

    private final String path;

    Bilder(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
