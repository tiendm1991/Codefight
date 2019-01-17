package tiendm.codefight.challenge.y2019.jan;

public class SnowflakeCrafts {
  String[] snowflakeCrafts(String[] f) {
    String r[] = new String[f.length * 2 - 1];
    for (int i = 0; i < f.length; i++) {
      if (i != 0) {
        int l = f[i].length() - 1;
        for (int j = i - 1; j >= 0; j--)
          f[i] += f[j].charAt(l);
      }
      r[r.length - 1 - i] = r[i] = new StringBuilder(f[i].substring(1)).reverse() + f[i];
    }
    return r;
  }
}
