const nextJest = require("next/jest");
const createJestConfig = nextJest({
    dir: "./",
});
const customJestConfig = {
    setupFilesAfterEnv: [require.resolve('@testing-library/jest-dom')],
    moduleDirectories: ["node_modules", "<rootDir>/"],
    testEnvironment: "jest-environment-jsdom",
};
module.exports = createJestConfig(customJestConfig);
