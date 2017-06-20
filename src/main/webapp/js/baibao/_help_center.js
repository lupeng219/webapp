;
(function () {
    var $smallNavlist = $(".smallNav>li"),
        $containTitle = $(".containTitle"),
        $bigNavs = $(".big-navs"),
        $contains = $(".contains"),
        $containSTitle = $(".containSTitle"),
        $contExplain = $(".contExplain"),
        $smallNav = $(".smallNav");
    $(document).ready(function () {
        $containTitle.find(".containSTitle").find("a").addClass("btn-open").css({
            "color": "#989898"
        });
        $containTitle.find(".contExplain").hide();
        $containTitle.find(".containSTitle:eq(0)").find("a").removeClass("btn-open").css({
            "color": "#09addf"
        });
        $containTitle.find(".contExplain:eq(0)").show();
        $contains.hide();
        $contains.eq(0).show();
        $bigNavs.eq(0).addClass("ico-push");
        $(".smallNav:eq(0)").show();
        $smallNavlist.eq(0).find(".ssjL").show();
        $smallNavlist.eq(0).find(".ksjL").show();
        leftL({

            THis: $smallNavlist.eq(0),
            leftLA: "leftLA",
            leftLine1: ".left-line"
        });
        $(".allHide").find(".containSTitle").find("a").addClass("btn-open").css({
            "color": "#989898"
        });
        $(".allHide").find(".contExplain").hide();
    });
    $smallNavlist.hover(function () {

        $(this).addClass("leftL");
        if ($(this).find(".left-line").hasClass("disShow")) {
            $(this).removeClass("leftL");
        }
    }, function () {
        $(this).removeClass("leftL");
    });

    $bigNavs.on('click', function () {
        var Index = $bigNavs.index(this);
        if ($(this).hasClass("ico-push")) {
            $(this).removeClass("ico-push");
            $smallNav.eq(Index).hide();
        } else {
            $bigNavs.removeClass("ico-push");
            $(this).addClass("ico-push");
            $smallNav.hide();
            $smallNav.eq(Index).show();
        }
    });
    var $oneShow = $(".oneShow"),
        $oneShowCS = $(".oneShow .containSTitle"),
        $allHide = $(".allHide"),
        $allHideCS = $(".allHide .containSTitle");
    $oneShow.on('click', '.containSTitle', function () {
        var Index = $oneShowCS.index(this);
        var $This = $oneShowCS.eq(Index).find("a");
        if ($This.hasClass("btn-open")) {
            Stys({
                Index: Index,
                $This: $This,
                HISH: ".oneShow .contExplain"
            });
        } else {
            StysEls({
                Index: Index,
                $This: $This,
                HISH: ".oneShow .contExplain"
            })

        }
        var Index = $oneShowCS.index(this);
        var $This = $oneShowCS.eq(Index).find("a");
    });
    $allHide.on('click', ".containSTitle", function () {
        var Index = $allHideCS.index(this);
        var $This = $allHideCS.eq(Index).find("a");
        if ($This.hasClass("btn-open")) {
            Stys({
                Index: Index,
                $This: $This,
                HISH: ".allHide .contExplain"
            });
            $(".allHide .containSTitle:not(:eq(" + Index + ")) a").addClass("btn-open").css({
                "color": "#989898"
            });
            $(".allHide .contExplain:not(:eq(" + Index + "))").hide();

        } else {
            StysEls({
                Index: Index,
                $This: $This,
                HISH: ".allHide .contExplain"
            });
        }

    });

    function Stys(elms) {
        elms.$This.removeClass("btn-open").css({
            "color": "#09addf"
        });
        $(elms.HISH).eq(elms.Index).show();
    };

    function StysEls(elms) {
        elms.$This.addClass("btn-open").css({
            "color": "#989898"
        });
        $(elms.HISH).eq(elms.Index).hide();
    };

    function leftL(eles) {
        eles.THis.find("a").addClass(eles.leftLA);
        eles.THis.find(eles.leftLine1).addClass("disShow");
        eles.THis.find(eles.ksjL).show();
        eles.THis.find(eles.ssjL).show();
    };

    function leftLNone(eles) {
        eles.THis.find("a").removeClass(eles.leftLA);
        eles.THis.find(eles.leftLine1).removeClass("disShow");
    }
    $smallNavlist.on('click', function () {
        var Index = $smallNavlist.index(this);
        $contains.hide();
        $contains.eq(Index).show();
        $smallNavlist.removeClass("leftL2");
        $smallNavlist.find("a").removeClass("leftLA");
        $smallNavlist.find(".left-line").removeClass("disShow");
        $smallNavlist.find(".ssjL").hide();
        $smallNavlist.find(".ksjL").hide();
        leftL({

            THis: $(this),
            leftLA: "leftLA",
            leftLine1: ".left-line",
            ssjL: ".ssjL",
            ksjL: ".ksjL"
        })

    });
})();