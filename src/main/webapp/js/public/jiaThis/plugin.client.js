/* (c) 2015 JiaThis Inc. 0326-2*/
var _gnayTrack = function () {
    var d = document,
        w = window,
        ws = w.screen,
        dm = w.location.host || "",
        dm = dm.replace(/^www\./, ''),
        na = navigator,
        ua = na.userAgent.toLowerCase(),
        se = {
            baidu: 'wd',
            google: 'q',
            soso: 'w',
            sogou: 'query',
            yahoo: 'p',
            youdao: 'q',
            iask: 'k',
            'sina': 'key',
            zhongsou: 'w',
            bing: 'q',
            so: 'q'
        },
        dms = {
            cn: 'com|org|gov|net',
            tw: 'com',
            hk: 'com'
        },
        ec = encodeURIComponent,
        //H = 'https://www.baibao.com',
        H = root;
        SWFID = 'JIATHISSWF',
        MU = H + '/images/c.gif',
        fO = {
            path: 'http://www.jiathis.com/code/swf/m.swf'
        },
        YAR = 315360000,
        JIDNAME = 'jid',
        cm = getDm(dm, 1),
        params = {},
        scr = d.getElementsByTagName('script');
    for (var i = 0, ss; ss = scr[i++];) {
        if (ss.src && (ss.src.indexOf('plugin.client.js') != -1)) {
            ss.src.replace(/(u|t|r|f)=([^&]+)/g, function (a, p, v) {
                params[p] = v
            })
        }
    }
    var r = trim(params['f'] == 'j' ? (params['r'] != null ? params['r'] : '') : d.referrer);

    function trim(s) {
        return s.replace(/^\s+|\s+$/g, '')
    }

    function genUv() {
        return new Date().getTime() + "" + Math.floor(Math.random() * 899 + 100)
    }

    function getUT(c) {
        var a = c;
        if (!def(a)) {
            a = genUv()
        }
        return {
            jid: a
        }
    }

    function getP(s, n, d) {
        s = n == 'p' ? s.replace("fp_ip=", "fp_ips=") : s;
        return s.match(new RegExp(n.replace(/([\[\]])/g, '\\\$1') + "=([^&\\?#]*)"), 'gm') ? RegExp.$1 : d || null
    }

    function getDm(h, g) {
        var k = h.split('.').reverse(),
            i = 0,
            l = k.length,
            o, ao;
        do {
            o = k[i];
            ao = k[i + 1];
            if (dms[o] && ao && ao.match(dms[o])) {
                break
            }
        } while (++i < l);
        o = k[i < l ? i + 2 : 1];
        if (g && o) {
            o = "." + h.match(new RegExp(".*(" + o + ".*?)$"))[1]
        }
        return o
    }

    function getRf(r) {
        if (r.match(/(?:[a-z]\:\/\/)([^\/\?]+)(.*)/gi)) {
            var o = {
                    host: RegExp.$1,
                    path: RegExp.$2
                },
                h = getDm(o.host),
                k;
            if (se[h] && (k = getP(o.path, se[h]))) {
                o.key = k;
                o.source = h
            }
            return o
        }
        return 0
    }

    function uptUt(f, a) {
        if (f) {
            if (a && a.jid) {
                f.writeSharedObject(JIDNAME, a.jid)
            }
        }
    }

    function req(u) {
        (new Image).src = u + '&time=' + new Date().getTime()
    }

    function reqUT(a) {
        var o = getRf(r),
            keyword = "",
            source = "",
            ref = "",
            url = 'id=' + a.jid + '&u=' + ec(trim(String(params['f'] == 'j' ? (params['u'] != null ? params['u'] : '') : d.location))) + '&t=' + ec(trim(String(params['f'] == 'j' ? (params['t'] != null ? params['t'] : '') : d.title)));
        if (o && o.host != dm && !o.host.match(dm.replace(/^www/, '').replace(/\./g, '\\.') + '$') && o.key && o.source) {
            keyword = ec(o.key);
            source = o.source
        }
        if (r) {
            ref = ec(r)
        }
        url += '&r=' + ref + '&k=' + keyword + '&s=' + source;
        req(MU + "?" + url)
    }

    function def(o) {
        return o && typeof o != 'undefined' && o != 'undefined'
    }
    reqUT({
        jid: ''
    })
}();