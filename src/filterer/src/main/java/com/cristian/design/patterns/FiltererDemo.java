package com.cristian.design.patterns;

import java.util.List;

import com.cristian.design.patterns.threat.ProbabilisticThreatAwareSystem;
import com.cristian.design.patterns.threat.ProbableThreat;
import com.cristian.design.patterns.threat.SimpleProbabilisticThreatAwareSystem;
import com.cristian.design.patterns.threat.SimpleProbableThreat;
import com.cristian.design.patterns.threat.SimpleThreat;
import com.cristian.design.patterns.threat.SimpleThreatAwareSystem;
import com.cristian.design.patterns.threat.Threat;
import com.cristian.design.patterns.threat.ThreatAwareSystem;
import com.cristian.design.patterns.threat.ThreatType;

public class FiltererDemo {

  public static void main(String[] args) {
    new FiltererDemo().run();
  }

  private void run() {
    filteringSimpleThreats();
    filteringSimpleProbableThreats();
  }

  private void filteringSimpleThreats() {
    System.out.println("### Filtering ThreatAwareSystem by ThreatType ###");

    final Threat rotkit = new SimpleThreat(ThreatType.ROOTKIT, 1, "Simple-Rootkit");
    final Threat trojan = new SimpleThreat(ThreatType.TROJAN, 1, "Simple-Trojan");
    final List<Threat> threats = List.of(rotkit, trojan);

    final ThreatAwareSystem simpleThreatAwareSystem = new SimpleThreatAwareSystem("Sys-1", threats);

    System.out.printf("Filtering ThreatAwareSystem. Initial : %s%n", simpleThreatAwareSystem);

    final ThreatAwareSystem rootkitThreatAwareSystem =
        simpleThreatAwareSystem.filtered().by(threat -> ThreatType.ROOTKIT.equals(threat.type()));

    System.out.printf("Filtered by threatType = ROOTKIT : %s%n", rootkitThreatAwareSystem);
  }

  private void filteringSimpleProbableThreats() {
    System.out.println("### Filtering ProbabilisticThreatAwareSystem by probability ###");

    final ProbableThreat trojanArcBomb = new SimpleProbableThreat("Trojan-ArcBomb", 1, ThreatType.TROJAN, 0.99);
    final ProbableThreat rootkit = new SimpleProbableThreat("Rootkit-Kernel", 2, ThreatType.ROOTKIT, 0.8);
    final List<ProbableThreat> probableThreats = List.of(trojanArcBomb, rootkit);

    final ProbabilisticThreatAwareSystem probabilisticThreatAwareSystem =
        new SimpleProbabilisticThreatAwareSystem("Sys-1", probableThreats);

    System.out.printf("Filtering ProbabilisticThreatAwareSystem. Initial : %s%n", probabilisticThreatAwareSystem);

    //Filtering using filterer
    final ProbabilisticThreatAwareSystem filteredThreatAwareSystem = probabilisticThreatAwareSystem.filtered()
        .by(probableThreat -> Double.compare(probableThreat.probability(), 0.99) == 0);

    System.out.printf("Filtered by probability = 0.99 : %s%n", filteredThreatAwareSystem);
  }
}
