package models;

public class Team {
    private String teamName;
    private String description;

    public Team setNameWithTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    public Team setWithDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDescription() {
        return description;
    }
}
