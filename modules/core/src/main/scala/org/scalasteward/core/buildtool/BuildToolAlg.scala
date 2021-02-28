/*
 * Copyright 2018-2021 Scala Steward contributors
 *
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

package org.scalasteward.core.buildtool

import org.scalasteward.core.data.Scope
import org.scalasteward.core.edit.scalafix.ScalafixMigration

trait BuildToolAlg[F[_], R] {
  def containsBuild(r: R): F[Boolean]

  def getDependencies(r: R): F[List[Scope.Dependencies]]

  def runMigration(r: R, migration: ScalafixMigration): F[Unit]
}
