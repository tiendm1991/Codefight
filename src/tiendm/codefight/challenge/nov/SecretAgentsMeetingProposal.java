package tiendm.codefight.challenge.nov;

import java.util.HashMap;
import java.util.Map;

public class SecretAgentsMeetingProposal {
  String[] secretAgentsMeetingProposal(String incomingMessage, int codeNumberDiff) {
    Map<String, String> map = new HashMap<>();
    map.put("0", "a");
    map.put("9", "e");
    map.put("8", "i");
    map.put("7", "o");
    map.put("6", "u");
    map.put("5", "y");
    map.put("4", "w");
    map.put("10", "t");
    map.put("11", "d");
    map.put("12", "s");
    map.put("13", "n");
    map.put("14", "m");
    map.put("15", "r");
    map.put("16", "b");
    map.put("17", "k");
    map.put("18", "p");
    map.put("*", "morning");
    map.put("@", "afternoon");
    map.put("#", "night");
    map.put("?", "-");
    String[] result = new String[2];
    result[0] = "";
    String[] message = incomingMessage.split("\\.");
    int increase = 0;
    for (String s : message) {
      if (s.equals("_")) {
        increase += codeNumberDiff;
        continue;
      }
      result[0] += map.get(increaseValue(s, increase));

    }
    result[1] = checkResult(result[0]);
    return result;
  }

  String checkResult(String result) {
    String[] split = result.split("-");
    if (split[0].equals("today")) {
      return split[2].equals("park") ? "5.9.12" : "13.7";
    } else if (split[0].equals("tomorrow")) {
      return (split[2].equals("bar") && split[1].equals("night"))
          || (split[2].equals("park") && split[1].equals("afternoon")) ? "5.9.12" : "13.7";
    } else {
      return split[2].equals("restaurant") && split[1].equals("morning") ? "5.9.12" : "13.7";
    }
  }

  String increaseValue(String s, int codeNumberDiff) {
    try {
      int x = Integer.parseInt(s);
      return (x + codeNumberDiff) + "";
    } catch (Exception e) {
      return s;
    }
  }

  public static void main(String[] args) {
    SecretAgentsMeetingProposal s = new SecretAgentsMeetingProposal();
    System.out.println(
        s.secretAgentsMeetingProposal("10.4.7.11.0.5._.10.?.*.?._.11.5.8.6.-4.2.11.-4.9.6", 2));
  }
}
