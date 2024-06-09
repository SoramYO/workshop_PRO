package validation;

import java.text.DecimalFormat;
import model.Developer;
import model.Employee;
import model.TeamLeader;
import model.Tester;

public class Until {
    public String formatEmployee(Employee employee) {
        DecimalFormat df = new DecimalFormat("#.0");
        if (employee instanceof Developer) {
            Developer dev = (Developer) employee;
            return String.format("%s_%s_%s_%s_[%s]_%d",
                    dev.getEmpID(),
                    dev.getEmpName(),
                    df.format(dev.getBaseBal()),
                    dev.getTeamName(),
                    String.join(", ", dev.getProgrammingLanguages()),
                    dev.getExpYear());
        } else if (employee instanceof TeamLeader) {
            TeamLeader leader = (TeamLeader) employee;
            return String.format("%s_%s_%s_%s_[%s]_%d_%.1f",
                    leader.getEmpID(),
                    leader.getEmpName(),
                    df.format(leader.getBaseBal()),
                    leader.getTeamName(),
                    String.join(", ", leader.getProgrammingLanguages()),
                    leader.getExpYear(),
                    leader.getBonus_rate());
        } else if (employee instanceof Tester) {
            Tester tester = (Tester) employee;
            return String.format("%s_%s_%s_%.1f_%s",
                    tester.getEmpID(),
                    tester.getEmpName(),
                    df.format(tester.getBaseBal()),
                    tester.getBonusRate(),
                    tester.getType());
        } else {
            return employee.toString();
        }
    }
}
