package cn.edu.whut.sept.zuul;

public enum ProbableAct implements Action {
    /**
     *
     */
    go {
        @Override
        public boolean actions(final Game game, final Command command) {
            game.goRoom(command);
            return false;
        }
    },
    /**
     * .
     */
    help {
        @Override
        public boolean actions(final Game game, final Command command) {
            game.printHelp();
            return false;
        }
    },
    /**
     * .
     */
    quit {
        @Override
        public boolean actions(final Game game, final Command command) {
            return game.quit(command);
        }
    }
}
