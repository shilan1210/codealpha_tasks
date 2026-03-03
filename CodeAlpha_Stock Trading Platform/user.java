 class User {

    private String username;
    private Portfolio portfolio;

    public User(String username) {
        this.username = username;
        this.portfolio = new Portfolio(100000, username);
    }

    public String getUsername() {
        return username;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}