package tiendm.codefight.challenge.april;

public class TimeFormat {

  String timeFormat(Long value, String f) {
    // if(value == 0) return "0y 0d 0h 0m 0s 0ms";
    if (f.trim().equals(""))
      f = "%y %d %h %m %s %ms";
    f = " " + f + " ";
    String ms = "", s = "", m = "", h = "", d = "", y = "";
    long MS = 0, S = -1, M = -1, H = -1, D = -1, Y = -1;
    if (f.indexOf("y") >= 0) {
      Y = value / 1000 / 60 / 60 / 24 / 365;
      y = Y + nvl("y", f);
    }
    if (f.indexOf("d") >= 0 || f.indexOf("%d") >= 0) {
      D = (value / 1000 / 60 / 60 / 24);
      if (Y != -1)
        D = D % 365;
      d = D + nvl("d", f);
    }
    if (f.indexOf("h") >= 0) {
      H = (value / 1000 / 60 / 60);
      if (D != -1)
        H = H % 24;
      else {
        if (Y != -1) {
          H = H % (365 * 24);
        }
      }
      h = H + nvl("h", f);
    }
    if (f.indexOf("m ") >= 0 || f.indexOf("%m ") >= 0) {
      M = (value / 1000 / 60);
      if (H != -1)
        M = M % 60;
      else if (D != -1) {
        M = M % (60 * 24);
      } else if (Y != -1) {
        M = M % (365 * 60 * 24);
      }
      m = M + nvl("m", f);
    }
    if (f.indexOf(" s") >= 0 || f.indexOf("%s") >= 0) {
      S = value / 1000;
      if (M != -1) {
        S = S % 60;
      } else if (H != -1) {
        S = S % (60 * 60);
      } else if (D != -1) {
        S = S % (60 * 60 * 24);
      } else if (Y != -1) {
        S = S % (365 * 60 * 60 * 24);
      }
      s = S + nvl("s", f);
    }

    if (f.indexOf("ms") >= 0) {
      MS = value;
      if (S != -1) {
        MS = MS % 1000;
      } else if (M != -1) {
        MS = MS % (1000 * 60);
      } else if (H != -1) {
        MS = MS % (1000 * 60 * 60);
      } else if (D != -1) {
        MS = MS % (1000 * 60 * 60 * 24);
      } else if (Y != -1) {
        MS = MS % (365 * 24 * 60 * 60 * 1000);
      }
      ms = MS + nvl("ms", f);
    }
    String result = y + check(d) + check(h) + check(m) + check(s) + check(ms);
    return result.trim();

  }

  String nvl(String s, String f) {
    return f.indexOf("%" + s) >= 0 ? s : "";
  }

  String check(String s) {
    return s.equals("") ? s : " " + s;
  }

  public static void main(String[] args) {
    TimeFormat time = new TimeFormat();
    String fomat = "";
    System.out.println(time.timeFormat(0L, fomat));
  }

}
