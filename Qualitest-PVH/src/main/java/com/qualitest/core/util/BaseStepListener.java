package com.qualitest.core.util;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.util.Project;

import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepListener;

public class BaseStepListener implements StepListener {

	private static final Logger Log = LoggerFactory.getLogger(BaseStepListener.class);

	public BaseStepListener() {
		Log.info("BaseStepListener()");
	}

	public void testSuiteStarted(final Class<?> testCase) {
		Log.info("test suite started");
	}

	public void testSuiteStarted(final Story story) {
		Log.info("test suite started");
	}

	public void testStarted(final String testName) {
		Log.info("test started " + testName);
		Project.beforeStep();
	}

	public void testStarted(String description, String id) {

		Log.info("test started " + description);
	}

	public void testFinished(TestOutcome result) {
		Log.info("TEST FINISHED");
		Project.afterTest();
	}

	public void testSuiteFinished() {
	}

	public void testRetried() {
	}

	public void skippedStepStarted(ExecutedStepDescription description) {
	}

	public void lastStepFailed(StepFailure stepFailure) {
	}

	public void stepIgnored() {
	}

	public void stepIgnored(String s) {
	}

	public void stepPending() {
	}

	public void stepPending(String s) {
	}

	public void assumptionViolated(String s) {
	}

	public void testRunFinished() {
		Log.info("test run finished");
	}

	public void stepStarted(ExecutedStepDescription executedStepDescription) {
		Log.info("STEP STARTED " + executedStepDescription.getName());
		Project.beforeStep();
	}
	public void stepFinished() {
		Log.info("STEP FINISHED");
		Project.afterStep();
	}

	public void stepFailed(StepFailure stepFailure) {
		Log.info("STEP FAILED");

		Project.afterStep();
	}

	public void testFailed(TestOutcome testOutcome, Throwable cause) {
		Log.info("TEST FINISHED (FAILED)");
		Project.afterTest();
	}

	public void testIgnored() {
	}

	@Override
	public void testSkipped() {
	}

	@Override
	public void testPending() {
	}

	@Override
	public void testIsManual() {
	}

	public void notifyScreenChange() {
	}

	public void useExamplesFrom(DataTable dataTable) {
	}

	@Override
	public void addNewExamplesFrom(DataTable dataTable) {
	}

	public void exampleStarted(Map<String, String> stringStringMap) {
	}

	public void exampleStarted() {
	}

	public void exampleFinished() {
	}

}
