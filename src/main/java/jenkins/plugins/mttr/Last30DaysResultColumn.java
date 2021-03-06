package jenkins.plugins.mttr;

import hudson.Extension;
import hudson.model.Job;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import jenkins.plugins.util.ReadUtil;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

public class Last30DaysResultColumn extends ListViewColumn {

    @DataBoundConstructor
    public Last30DaysResultColumn() {
    }

    public String getResult(Job job) throws IOException {
        return ReadUtil.getColumnResult(job, MTTRAction.LAST_30_DAYS);
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {
        public DescriptorImpl() {
        }

        public String getDisplayName() {
            return Messages.last30DaysBuildsColumnTitle();
        }

        @Override
        public boolean shownByDefault() {
            return false;
        }
    }
}
