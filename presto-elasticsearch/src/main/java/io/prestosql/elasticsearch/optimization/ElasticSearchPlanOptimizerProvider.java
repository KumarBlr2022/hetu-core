/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.elasticsearch.optimization;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import io.prestosql.spi.ConnectorPlanOptimizer;
import io.prestosql.spi.connector.ConnectorPlanOptimizerProvider;

import java.util.Set;

public class ElasticSearchPlanOptimizerProvider
        implements ConnectorPlanOptimizerProvider
{
    private ElasticSearchPlanOptimizer elasticSearchPlanOptimizer;

    @Inject
    public ElasticSearchPlanOptimizerProvider(ElasticSearchPlanOptimizer elasticSearchPlanOptimizer)
    {
        this.elasticSearchPlanOptimizer = elasticSearchPlanOptimizer;
    }

    @Override
    public Set<ConnectorPlanOptimizer> getLogicalPlanOptimizers()
    {
        return ImmutableSet.of(elasticSearchPlanOptimizer);
    }

    @Override
    public Set<ConnectorPlanOptimizer> getPhysicalPlanOptimizers()
    {
        return ImmutableSet.of();
    }
}
